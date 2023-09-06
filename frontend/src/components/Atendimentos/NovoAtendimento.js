import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './NovoAtendimento.css';
import TabelaAtendimento from './TabelaAtendimento';

function NovoAtendimento() {
    const [atendimentos, setAtendimentos] = useState([]);
    const [atendimentoAtual, setAtendimentoAtual] = useState({
        data: '',
        hora: '',
        cliente: 0,
        barbeiro: 0,
        servicos: [],
        item: {
            produtos: []
        },
        pagamento: '',
    });
    const [data, setData] = useState('');
    const [hora, setHora] = useState('');
    const [clientes, setClientes] = useState([]);
    const [cliente, setCliente] = useState(0);
    const [barbeiros, setBarbeiros] = useState([]);
    const [barbeiro, setBarbeiro] = useState(0);
    const [servicos, setServicos] = useState([]);
    const [servicosSelecionados, setServicosSelecionados] = useState([]);
    const [produtos, setProdutos] = useState([]);
    const [produtosSelecionados, setProdutosSelecionados] = useState([]);
    const [pagamento, setPagamento] = useState('');
    const [btnCadastrarAtendimento, setBtnCadastrarAtendimento] = useState(true);
    const [quantidadeProduto, setQuantidadeProduto] = useState(1);
    const [modoEdicao, setModoEdicao] = useState(true);

    useEffect(() => {
        axios.get('http://localhost:8080/listarCliente')
            .then(response => {
                setClientes(response.data);
            })
            .catch(error => {
                console.error(error);
            });

        axios.get('http://localhost:8080/listarBarbeiro')
            .then(response => {
                setBarbeiros(response.data);
            })
            .catch(error => {
                console.error(error);
            });

        axios.get('http://localhost:8080/listarServicos')
            .then(response => {
                setServicos(response.data);
            })
            .catch(error => {
                console.error(error);
            });

        axios.get('http://localhost:8080/listarProdutos')
            .then(response => {
                setProdutos(response.data);
            })
            .catch(error => {
                console.error(error);
            });

        fetch('http://localhost:8080/listarAtendimentos')
            .then((retorno) => retorno.json())
            .then((retorno_convertido) => {
                setAtendimentos(retorno_convertido);
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);

    useEffect(() => {
        console.log(cliente)
    }, [cliente])

    const handleServicoSelection = (e) => {
        const servicoId = Number(e.target.value);
        if (e.target.checked) {
            setServicosSelecionados([...servicosSelecionados, { id: servicoId }]);
        } else {
            setServicosSelecionados(servicosSelecionados.filter((s) => s.id !== servicoId));
        }
    };

    const handleProdutoSelection = (e) => {
        const produtoId = Number(e.target.value);
        const isChecked = e.target.checked;
        const produto = produtos.find((p) => p.id === produtoId);

        if (isChecked) {
            const quantidade = 1;
            const valorTotalProduto = produto.preco * quantidade;

            setProdutosSelecionados([
                ...produtosSelecionados,
                { id: produtoId, quantidade: quantidade, valorTotal: valorTotalProduto },
            ]);

            setAtendimentoAtual((atendimentoAtual) => ({
                ...atendimentoAtual,
                total: atendimentoAtual.total + valorTotalProduto,
            }));
        } else {
            const produtoSelecionado = produtosSelecionados.find((p) => p.id === produtoId);
            if (produtoSelecionado) {
                const valorTotalProduto = produtoSelecionado.valorTotal;
                setProdutosSelecionados(produtosSelecionados.filter((p) => p.id !== produtoId));
                setAtendimentoAtual((atendimentoAtual) => ({
                    ...atendimentoAtual,
                    total: atendimentoAtual.total - valorTotalProduto,
                }));
            }
        }
    };

    const adicionarProduto = (produto, quantidade) => {
        if (produto !== null && quantidade > 0) {
            const newItem = { ...atendimentoAtual.item };
            newItem.produtos.push({ produto, quantidade });
            setAtendimentoAtual({ ...atendimentoAtual, item: newItem });
            // Atualizar o total do atendimento com base no novo item
            recalcularTotal();
        } else {
            throw new Error("Produto ou quantidade inválida.");
        }
    };

    const removerProduto = (index) => {
        const newItem = { ...atendimentoAtual.item };
        newItem.produtos.splice(index, 1);
        setAtendimentoAtual({ ...atendimentoAtual, item: newItem });
        // Atualizar o total do atendimento com base no novo item
        recalcularTotal();
    };

    const atualizarQuantidadeProduto = (index, novaQuantidade) => {
        novaQuantidade = parseInt(novaQuantidade, 10);
        if (!isNaN(novaQuantidade)) {
            const newItem = { ...atendimentoAtual.item };
            newItem.produtos[index].quantidade = novaQuantidade;
            setAtendimentoAtual({ ...atendimentoAtual, item: newItem });
            // Atualizar o total do atendimento com base no novo item
            recalcularTotal();
        }
    };

    const recalcularTotal = () => {
        const total = atendimentoAtual.item.produtos.reduce((acc, item) => {
            return acc + item.produto.preco * item.quantidade;
        }, 0);
        setAtendimentoAtual({ ...atendimentoAtual, total });
    };

    const handleQuantidadeProdutoChange = (produtoId, novaQuantidade) => {
        novaQuantidade = parseInt(novaQuantidade, 10);
        if (!isNaN(novaQuantidade)) {
            setProdutosSelecionados((produtosSelecionados) =>
                produtosSelecionados.map((produtoSelecionado) =>
                    produtoSelecionado.id === produtoId
                        ? { ...produtoSelecionado, quantidade: novaQuantidade }
                        : produtoSelecionado
                )
            );
    
            // Atualize o valor total do produto no atendimento
            const produtoSelecionado = produtosSelecionados.find((p) => p.id === produtoId);
            if (produtoSelecionado) {
                const valorTotalProduto = produtoSelecionado.preco * novaQuantidade;
                setAtendimentoAtual((atendimentoAtual) => ({
                    ...atendimentoAtual,
                    total: atendimentoAtual.total - produtoSelecionado.valorTotal + valorTotalProduto,
                }));
            }
        }
    };




    const limparFormulario = () => {
        setData('');
        setHora('');
        setCliente('');
        setBarbeiro('');
        setServicosSelecionados([]);
        setProdutosSelecionados([]);
        setPagamento('');
        setBtnCadastrarAtendimento(true);
    };
    const cancelar = () => {
        setData('');
        setHora('');
        setCliente('');
        setBarbeiro('');
        setServicosSelecionados([]);
        setProdutosSelecionados([]);
        setPagamento('');
        setModoEdicao(true);
        setBtnCadastrarAtendimento(false);
    }


    const selecionarAtendimento = (indice) => {
        const atendimentoSelecionado = atendimentos[indice];
        setAtendimentoAtual(atendimentoSelecionado);
        setData(atendimentoSelecionado.data);
        setHora(atendimentoSelecionado.hora);
        setCliente(atendimentoSelecionado.cliente.id);
        setBarbeiro(atendimentoSelecionado.barbeiro.id);
        setServicosSelecionados(atendimentoSelecionado.servicos.map((servico) => servico.id));
        setProdutosSelecionados(atendimentoSelecionado.produtos.map((produto) => produto.id));
        setPagamento(atendimentoSelecionado.pagamento);
        setModoEdicao(false);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!cliente || !barbeiro || servicosSelecionados.length === 0 || produtosSelecionados.length === 0) {
            return;
        }

        const newAtendimento = {
            data,
            hora,
            cliente: { id: Number(cliente) },
            barbeiro: { id: Number(barbeiro) },
            servicos: servicosSelecionados,
            produtos: produtosSelecionados.map((produtoSelecionado) => ({
                id: produtoSelecionado.id,
                quantidade: produtoSelecionado.quantidade,
            })),
            pagamento,
        };

        console.log(newAtendimento, cliente, barbeiro);

        axios.post('http://localhost:8080/novoAtendimento', newAtendimento)
            .then(response => {
                console.log(response.data);
                fetch('http://localhost:8080/listarAtendimentos')
                    .then((retorno) => retorno.json())
                    .then((retorno_convertido) => {
                        setAtendimentos(retorno_convertido);
                        limparFormulario();
                    })
                    .catch((error) => {
                        console.error(error);
                    });
            })
            .catch(error => {
                console.error(error);
            });
    };

    const handleDeletarAtendimento = () => {
        if (!atendimentoAtual.id) {
            return;
        }

        axios
            .delete(`http://localhost:8080/deletarAtendimentoId/${atendimentoAtual.id}`)
            .then((response) => {
                console.log(response.data);
                fetch('http://localhost:8080/listarAtendimentos')
                    .then((retorno) => retorno.json())
                    .then((retorno_convertido) => {
                        setAtendimentos(retorno_convertido);
                        limparFormulario();
                        setModoEdicao(true);
                    })
                    .catch((error) => {
                        console.error('Erro ao buscar lista de atendimentos:', error);
                    });
            })
            .catch((error) => {
                console.error('Erro ao excluir atendimento:', error);
            });
    };

    const handleAtualizarAtendimento = () => {
        if (!cliente || !barbeiro || servicosSelecionados.length === 0 || produtosSelecionados.length === 0 ||  !atendimentoAtual.id) {
            return;
        }
        axios
            .put(`http://localhost:8080/atualizarAtendimentoId/${atendimentoAtual.id}`, atendimentos)
            .then((response) => {
                console.log(response.data);

                fetch('http://localhost:8080/listarAtendimentos')
                    .then((retorno) => retorno.json())
                    .then((retorno_convertido) => {
                        setAtendimentos(retorno_convertido);
                        limparFormulario();
                    })
                    .catch((error) => {
                        console.error('Erro ao buscar lista de atendimentos:', error);
                    });
            })
            .catch((error) => {
                console.error('Erro ao atualizar atendimento:', error);
            });
    };

    return (
        <div>
            <h2>Novo Atendimento</h2>
            <form onSubmit={handleSubmit}>
                <div className="column">
                    <h3>Selecionar Cliente</h3>
                    <select
                        placeholder="Cliente"
                        value={cliente}
                        onChange={e => setCliente(e.target.value)}
                    >
                        <option value="0" disabled> Selecione uma opção</option>
                        {clientes.map(cliente => (
                            <option key={cliente.id} value={cliente.id} >
                                {cliente.nome}
                            </option>
                        ))}
                    </select>
                </div>
                <div className="column">
                    <h3>Selecionar Barbeiro</h3>
                    <select
                        placeholder="Barbeiro"
                        value={barbeiro}
                        onChange={e => setBarbeiro(e.target.value)}
                    >
                        <option value="0" disabled> Selecione uma opção</option>
                        {barbeiros.map(barbeiro => (
                            <option key={barbeiro.id} value={barbeiro.id}>
                                {barbeiro.nome}
                            </option>
                        ))}
                    </select>
                </div>
                <div className="column">
                    <details>
                        <summary>Selecionar Serviço(s)</summary>
                        {servicos.map((servico) => (
                            <label key={servico.id} className="select-option">
                                <input
                                    type="checkbox"
                                    value={servico.id}
                                    checked={servicosSelecionados.some((s) => s.id === servico.id)}
                                    onChange={handleServicoSelection}
                                />
                                {servico.nome}
                            </label>
                        ))}
                    </details>
                </div>
                <div className="column">
                    <details>
                        <summary>Selecionar Produto(s)</summary>
                        {produtos.map((produto) => (
                            <label key={produto.id} className="select-option">
                                <input
                                    type="checkbox"
                                    value={produto.id}
                                    checked={produtosSelecionados.some((p) => p.id === produto.id)}
                                    onChange={handleProdutoSelection}
                                />
                                {produto.nome}
                            </label>
                        ))}
                    </details>
                </div>
                {produtosSelecionados.map((produtoSelecionado) => (
                    <div key={produtoSelecionado.id} className="column">
                        <h3>Quantidade de {produtos.find(p=>p.id == produtoSelecionado.id).nome}</h3>
                        <input
                            type="number"
                            placeholder="Quantidade"
                            value={produtoSelecionado.quantidade}
                            onChange={(e) => handleQuantidadeProdutoChange(produtoSelecionado.id, e.target.value)}
                        />
                    </div>
                ))}
                <div className="column">
                    <h3>Data</h3>
                    <input
                        type="text"
                        placeholder="Data"
                        value={data}
                        onChange={e => setData(e.target.value)}
                    />
                </div>
                <div className="column">
                    <h3>Hora</h3>
                    <input
                        type="text"
                        placeholder="Hora"
                        value={hora}
                        onChange={e => setHora(e.target.value)}
                    />
                </div>
                <div className="column">
                    <h3>Pagamento</h3>
                    <input
                        type="text"
                        placeholder="Pagamento"
                        value={pagamento}
                        onChange={e => setPagamento(e.target.value)}
                    />
                </div>
                {
                    modoEdicao
                        ?
                        <button type="submit" className='btn btn-primary'>Criar Atendimento</button>
                        :
                        <div>
                            <input type="button" value='Alterar' className='btn btn-warning' onClick={handleAtualizarAtendimento} />
                            <input type="button" value="Remover" className='btn btn-danger' onClick={handleDeletarAtendimento} />
                            <input type="button" value="Cancelar" className='btn btn-secondary' onClick={cancelar} />
                            <input type="button" value="Concluído" className='btn btn-primary' onClick={handleDeletarAtendimento} />
                        </div>
                }
            </form>
            <TabelaAtendimento vetor={atendimentos} selecionar={selecionarAtendimento} />
        </div>
    );
}

export default NovoAtendimento;