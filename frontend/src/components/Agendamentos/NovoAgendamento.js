import React, { useState, useEffect } from 'react';
import axios from 'axios';

function NovoAgendamento() {
  const [clientes, setClientes] = useState([]);
  const [barbeiros, setBarbeiros] = useState([]);
  const [servicos, setServicos] = useState([]);
  const [clienteSelecionado, setClienteSelecionado] = useState(null);
  const [barbeiroSelecionado, setBarbeiroSelecionado] = useState(null);
  const [servicosSelecionados, setServicosSelecionados] = useState([]);
  const [data, setData] = useState('');
  const [hora, setHora] = useState('');
  const [observacao, setObservacao] = useState('');

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
  }, []);

  const handleServicoSelection = servico => {
    const isSelected = servicosSelecionados.some(s => s.id === servico.id);
    if (isSelected) {
      setServicosSelecionados(servicosSelecionados.filter(s => s.id !== servico.id));
    } else {
      setServicosSelecionados([...servicosSelecionados, { id: servico.id }]);
    }
  };

  const handleSubmit = e => {
    e.preventDefault();

    if (!clienteSelecionado || !barbeiroSelecionado || servicosSelecionados.length === 0) {
      return; // Certifique-se de que os três itens foram selecionados
    }

    const newAgendamento = {
      cliente: { id: clienteSelecionado.id },
      barbeiro: { id: barbeiroSelecionado.id },
      servicos: servicosSelecionados.map(servico => ({ id: servico.id })),
      data,
      hora,
      observacao
    };

    axios.post('http://localhost:8080/novoAgendamento', newAgendamento)
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  };
  return (
    <div>
      <h2>Novo Agendamento</h2>
      <form onSubmit={handleSubmit}>
        <div className="column">
          <h3>Selecionar Cliente</h3>
          {clientes.map(cliente => (
            <p key={cliente.id} onClick={() => setClienteSelecionado(cliente)}>
              {cliente.nome}
            </p>
          ))}
        </div>
        <div className="column">
          <h3>Selecionar Barbeiro</h3>
          {barbeiros.map(barbeiro => (
            <p key={barbeiro.id} onClick={() => setBarbeiroSelecionado(barbeiro)}>
              {barbeiro.nome}
            </p>
          ))}
        </div>
        <div className="column">
          <h3>Selecionar Serviços</h3>
          {servicos.map(servico => (
            <p
              key={servico.id}
              className={servicosSelecionados.some(s => s.id === servico.id) ? 'selected' : ''}
              onClick={() => handleServicoSelection(servico)}
            >
              {servico.nome}
            </p>
          ))}
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
        <button type="submit">Criar Agendamento</button>
      </form>
    </div>
  );
}

export default NovoAgendamento;