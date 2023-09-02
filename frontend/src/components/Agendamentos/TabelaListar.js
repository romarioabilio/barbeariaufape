import React from 'react';

function TabelaListar({ vetor, selecionar }) {
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
            <th>Total</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {vetor &&
            vetor.map((agendamento, indice) => (
              <tr key={agendamento.id}>
                <td>{indice + 1}</td>
                <td>{agendamento.cliente ? agendamento.cliente.nome : ''}</td>
                <td>{agendamento.barbeiro ? agendamento.barbeiro.nome : ''}</td>
                <td>
                  {agendamento.servicos &&
                    agendamento.servicos.map((servico, index) => (
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
                  {
                    `R$${agendamento.total.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`
                     }
              </td>
                <td>
                  <button
                    onClick={() => {
                      selecionar(indice);
                    }}
                    className="btn btn-success"
                  >
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

export default TabelaListar;