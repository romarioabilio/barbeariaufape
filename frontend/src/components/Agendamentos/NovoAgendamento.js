import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './NovoAgendamento.css';
import TabelaAgendamento from './TabelaAgendamento';

function NovoAgendamento() {
  const agendamentoInicial = {
    cliente: {},
    barbeiro: {},
    servicos: [],
    data: '',
    hora: '',
    observacao: '',
  };
  const [agendamentos, setAgendamentos] = useState([]);
  const [agendamentoAtual, setAgendamentoAtual] = useState(agendamentoInicial);
  const [clientes, setClientes] = useState([]);
  const [cliente, setCliente] = useState(0);
  const [barbeiros, setBarbeiros] = useState([]);
  const [barbeiro, setBarbeiro] = useState(0);
  const [servicos, setServicos] = useState([]);
  const [servicosSelecionados, setServicosSelecionados] = useState([]);
  const [data, setData] = useState('');
  const [hora, setHora] = useState('');
  const [observacao, setObservacao] = useState('');
  const [btnCadastrarAgendamento, setBtnCadastrarAgendamento] = useState(true);
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

    fetch('http://localhost:8080/listarAgendamentos')
      .then((retorno) => retorno.json())
      .then((retorno_convertido) => {
        setAgendamentos(retorno_convertido);
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


  const limparFormulario = () => {
    setCliente('');
    setBarbeiro('');
    setServicosSelecionados([]);
    setData('');
    setHora('');
    setObservacao('');
    setModoEdicao(true);
    setBtnCadastrarAgendamento(true);
  };
  const cancelar = () => {
    setCliente('');
    setBarbeiro('');
    setServicosSelecionados([]);
    setData('');
    setHora('');
    setObservacao('');
    setModoEdicao(true);
    setBtnCadastrarAgendamento(false);
  }
 
  const selecionarAgendamento = (indice) => {
    const agendamentoSelecionado = agendamentos[indice];
    setAgendamentoAtual(agendamentoSelecionado);
    setCliente(agendamentoSelecionado.cliente.id);
    setBarbeiro(agendamentoSelecionado.barbeiro.id);
    setServicosSelecionados(agendamentoSelecionado.servicos.map((servico) => servico.id));
    setData(agendamentoSelecionado.data);
    setHora(agendamentoSelecionado.hora);
    
   
  setObservacao(agendamentoSelecionado.observacao);
    
    
  setModoEdicao(false);
  };

  const handleSubmit = e => {
    e.preventDefault();

    if (!cliente || !barbeiro || servicosSelecionados.length === 0) {
      return; 
    }

    const newAgendamento = {
      cliente: { id: Number(cliente) },
      barbeiro: { id: Number(barbeiro) },
      servicos: servicosSelecionados,
      data,
      hora,
      observacao
    };

    console.log(newAgendamento, cliente, barbeiro);

    axios.post('http://localhost:8080/novoAgendamento', newAgendamento)
      .then(response => {
        console.log(response.data);
        fetch('http://localhost:8080/listarAgendamentos')
          .then((retorno) => retorno.json())
          .then((retorno_convertido) => {
            setAgendamentos(retorno_convertido);
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

  const handleDeletarAgendamento = () => {
    if (!agendamentoAtual.id) {
      return;
    }
    
    axios
      .delete(`http://localhost:8080/deletarAgendamentoId/${agendamentoAtual.id}`)
      .then((response) => {
        console.log(response.data);
        fetch('http://localhost:8080/listarAgendamentos')
          .then((retorno) => retorno.json())
          .then((retorno_convertido) => {
            setAgendamentos(retorno_convertido);
            limparFormulario();
            setModoEdicao(true);
          })
          .catch((error) => {
            console.error('Erro ao buscar lista de agendamentos:', error);
          });
      })
      .catch((error) => {
        console.error('Erro ao excluir agendamento:', error);
      });
  };
  
  const handleAtualizarAgendamento = () => {
    if (!cliente || !barbeiro || servicosSelecionados.length === 0 || !agendamentoAtual.id) {
      return;
    }
  
    const updatedAgendamento = {
      id: agendamentoAtual.id,
      cliente: { id: Number(cliente) },
      barbeiro: { id: Number(barbeiro) },
      servicos: servicosSelecionados.map(id => ({ id })),
      data,
      hora,
      observacao,
    };
  
    axios
  .put(`http://localhost:8080/atualizarAgendamentoId/${agendamentoAtual.id}`, updatedAgendamento)
  .then((response) => {
    console.log(response.data);
    
   
fetch('http://localhost:8080/listarAgendamentos')
      .then((retorno) => retorno.json())
      .then((retorno_convertido) => {
        setAgendamentos(retorno_convertido);
        limparFormulario();
        setModoEdicao(false);
      })
      .catch((error) => {
        console.error('Erro ao buscar lista de agendamentos:', error);
      });
  })
  .catch((error) => {
    console.error('Erro ao atualizar agendamento:', error);
  });
  }
  
  return (
    <div>
      <h2>Novo Agendamento</h2>
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
            <summary>Selecionar Serviços</summary>
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
          <h3>Observação</h3>
          <input
            type="text"
            placeholder="Observação"
            value={observacao}
            onChange={e => setObservacao(e.target.value)}
          />
        </div>
        {
                modoEdicao
                ?
                <button type="submit" className='btn btn-primary'>Criar Agendamento</button>
                :
                <div>
                    <input type="button" value='Alterar' className='btn btn-warning' onClick={handleAtualizarAgendamento}  />
                    <input type="button" value="Remover" className='btn btn-danger' onClick={handleDeletarAgendamento} />
                    <input type="button" value="Cancelar" className='btn btn-secondary' onClick={cancelar}/>
                    <input type="button" value="Concluído" className='btn btn-success' onClick={handleDeletarAgendamento} />
                </div>
            }
      </form>
      <TabelaAgendamento vetor={agendamentos} selecionar={selecionarAgendamento} />
    </div>
  );
}

export default NovoAgendamento;