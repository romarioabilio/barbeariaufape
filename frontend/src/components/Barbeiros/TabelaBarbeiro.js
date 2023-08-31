import React, { useState, useEffect } from 'react';

function formatarData(dataString) {
  const data = new Date(dataString);
  const dia = data.getDate().toString().padStart(2, '0');
  const mes = (data.getMonth() + 1).toString().padStart(2, '0');
  const ano = data.getFullYear().toString();

  return `${dia}/${mes}/${ano}`;
}


function TabelaBarbeiro({ vetor, selecionar }) {
  const [termoPesquisa, setTermoPesquisa] = useState('');

  const filtroBarbeiros = vetor.filter((barbeiro) =>
    barbeiro.nome.toLowerCase().includes(termoPesquisa.toLowerCase())
  );

  return (
    <div>
      <input
        type="text"
        value={termoPesquisa}
        onChange={(e) => setTermoPesquisa(e.target.value)}
        placeholder="Pesquisar por nome"
        className="form-control mb-3"
      />

      <table className="table">
      <thead>
          <tr>
            <th>#</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Telefone</th>
            <th>Email</th>
            <th>Data de Nascimento</th>
            <th>Rua</th>
            <th>Bairro</th>
            <th>Estado</th>
            <th>CEP</th>
            <th>Número</th>
            <th>Cidade</th>
            <th>Especialidade</th>
            <th>Salário</th>
            <th>Selecionar</th>
          </tr>
        </thead>
        <tbody>
          {filtroBarbeiros.map((obj, indice) => (
            <tr key={indice}>
              <td>{indice + 1}</td>
              <td>{obj.nome}</td>
              <td>{obj.cpf}</td>
              <td>{obj.telefone}</td>
              <td>{obj.email}</td>
              <td>{formatarData(obj.dataNascimento)}</td>
              <td>{obj.endereco.rua}</td>
              <td>{obj.endereco.bairro}</td>
              <td>{obj.endereco.estado}</td>
              <td>{obj.endereco.cep}</td>
              <td>{obj.endereco.numero}</td>
              <td>{obj.endereco.cidade}</td>
              <td>{obj.especialidade}</td>
              <td>
                  {obj.salario
                    ? `R$${obj.salario.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`
                    : 'Salário não especificado'}
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

export default TabelaBarbeiro;
