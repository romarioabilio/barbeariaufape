import React, { useState, useEffect } from 'react';
import axios from 'axios';

function TabelaAgendamento() {
  const [agendamentos, setAgendamentos] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/listarAgendamentos')
      .then(response => {
        setAgendamentos(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  return (
    <div>
      <h2>Lista de Agendamentos</h2>
      <table className="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Cliente</th>
            <th>Barbeiro</th>
            <th>Serviços</th>
            <th>Data</th>
            <th>Hora</th>
            <th>Observação</th>
          </tr>
        </thead>
        <tbody>
          {agendamentos.map((agendamento, indice) => (
            <tr key={agendamento.id}>
              <td>{indice + 1}</td>
              <td>{agendamento.cliente.nome}</td>
              <td>{agendamento.barbeiro.nome}</td>
              <td>
                {agendamento.servicos.map((servico, index) => (
                  <span key={servico.id}>
                    {servico.nome}
                    {index < agendamento.servicos.length - 1 && ', '}
                  </span>
                ))}
              </td>
              <td>{agendamento.data}</td>
              <td>{agendamento.hora}</td>
              <td>{agendamento.observacao}</td>

              <td>
                <button className="btn btn-success">
                  Selecionar
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TabelaAgendamento;
