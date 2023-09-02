import React from 'react';
import { Link } from 'react-router-dom';
import './NovoAtendimento.css';

function TabelaAtendimento({ vetor, selecionar }) {
  return (
    <div>
      <table className="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Cliente</th>
            <th>Barbeiro</th>
            <th>Serviços</th>
            <th>Produtos</th>
            <th>Data</th>
            <th>Hora</th>
            <th>Pagamento</th>
            <th>Total</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {vetor &&
            vetor.map((atendimento, indice) => (
              <tr key={atendimento.id}>
                <td>{indice + 1}</td>
                <td>{atendimento.cliente ? atendimento.cliente.nome : ''}</td>
                <td>{atendimento.barbeiro ? atendimento.barbeiro.nome : ''}</td>
                <td>
                  {atendimento.servicos &&
                    atendimento.servicos.map((servico, index) => (
                      <span key={servico.id}>
                        {servico.nome}
                        {index < atendimento.servicos.length - 1 && ', '}
                      </span>
                    ))}
                </td>
                <td>
                  {atendimento.produtos &&
                    atendimento.produtos.map((produto, index) => (
                      <span key={produto.id}>
                        {produto.nome}
                        {index < atendimento.produtos.length - 1 && ', '}
                      </span>
                    ))}
                </td>
                <td>{atendimento.data}</td>
                <td>{atendimento.hora}</td>
                <td>{atendimento.pagamento}</td>
                <td>
                  {
                    `R$${atendimento.total.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`
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

export default TabelaAtendimento;