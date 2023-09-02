import  { useState } from 'react';
import { Link } from 'react-router-dom';

function TabelaListar({ vetor, selecionar }) {
  const [filtroNomeBarbeiro, setFiltroNomeBarbeiro] = useState('');

  const filtrarAgendamentos = () => {
    return vetor.filter(agendamento => {
      if (!filtroNomeBarbeiro) return true; // Retorna todos se nenhum filtro estiver definido
      return (
        agendamento.barbeiro &&
        agendamento.barbeiro.nome.toLowerCase().includes(filtroNomeBarbeiro.toLowerCase())
      );
    });
  };
  
  return (
    <div>
    <h2>Lista de Agendamentos</h2>
    
    {/* Campo de pesquisa por nome de barbeiro */}
    <div className="mb-3">
      <label htmlFor="nomeBarbeiro">Pesquisar por Nome de Barbeiro:</label>
      <input
        type="text"
        id="nomeBarbeiro"
        className="form-control"
        value={filtroNomeBarbeiro}
        onChange={(e) => setFiltroNomeBarbeiro(e.target.value)}
      />
    </div>
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
          
            {filtrarAgendamentos().map((agendamento, indice) => (
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
      <div className='Botao'>
        <button>
          <Link to="/">Ir para a página inicial</Link>
        </button>
        </div>
    </div>
  );
}

export default TabelaListar;