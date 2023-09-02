import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './NovoAtendimento.css';
import TabelaAtendimento from './TabelaAtendimento';

function NovoAtendimento() {
    const atendimentoInicial = {
        data: '',
        hora: '',
        cliente: {},
        barbeiro: {},
        servicos: [],
        produtos: [],
        pagamento: '',
    };
    const [atendimentos, setAtendimentos] = useState([]);
    const [atendimentoAtual, setAtendimentoAtual] = useState(atendimentoInicial);
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
            // Se a caixa de seleção estiver marcada, adiciona o serviço aos selecionados
            setServicosSelecionados([...servicosSelecionados, { id: servicoId }]);
        } else {
            // Se a caixa de seleção estiver desmarcada, remove o serviço dos selecionados
            setServicosSelecionados(servicosSelecionados.filter((s) => s.id !== servicoId));
        }
    };

    const handleProdutoSelection = (e) => {
        const produtoId = Number(e.target.value);

        if (e.target.checked) {
            // Se a caixa de seleção estiver marcada, adiciona o serviço aos selecionados
            setProdutosSelecionados([...produtosSelecionados, { id: produtoId }]);
        } else {
            // Se a caixa de seleção estiver desmarcada, remove o serviço dos selecionados
            setProdutosSelecionados(produtosSelecionados.filter((p) => p.id !== produtoId));
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
            return; // Certifique-se de que os quatros itens foram selecionados
        }

        const newAtendimento = {
            data,
            hora,
            cliente: { id: Number(cliente) },
            barbeiro: { id: Number(barbeiro) },
            servicos: servicosSelecionados,
            produtos: produtosSelecionados,
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
        if (!cliente || !barbeiro || servicosSelecionados.length === 0 || !atendimentoAtual.id) {
          return;
        }
      
        const updatedAtendimento = {
          id: atendimentoAtual.id,
          data,
          hora,
          cliente: { id: Number(cliente) },
          barbeiro: { id: Number(barbeiro) },
          servicos: servicosSelecionados,
          produtos: produtosSelecionados,
          pagamento,
        };
      
        axios
          .put(`http://localhost:8080/atualizarAtendimentoId/${atendimentoAtual.id}`, updatedAtendimento)
          .then((response) => {
            console.log(response.data);
      
            fetch('http://localhost:8080/listarAtendimentos')
              .then((retorno) => retorno.json())
              .then((retorno_convertido) => {
                setAtendimentos(retorno_convertido);
                limparFormulario();
                setModoEdicao(false);
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