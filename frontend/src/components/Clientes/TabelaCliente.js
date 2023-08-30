import React from 'react'

const TabelaCliente = ({clientes}) => {
    return (
        <table className='table'>
        <thead>
          <tr>
            <th>Nome</th>
            <th>CPF</th>
            <th>Email</th>
            <th>Rua</th>
            <th>Bairro</th>
            <th>Estado</th>
            <th>CEP</th>
            <th>Número</th>
            <th>Cidade</th>
            <th>Selecionar</th>
          </tr>
        </thead>
        <tbody>
          {clientes.map((cliente) => (
            <tr key={cliente.id}>
                <td>{cliente.nome}</td>
                <td>{cliente.cpf}</td>
                <td>{cliente.email}</td>
                <td>{cliente.endereco.rua}</td>
                <td>{cliente.endereco.bairro}</td>
                <td>{cliente.endereco.estado}</td>
                <td>{cliente.endereco.cep}</td>
                <td>{cliente.endereco.numero}</td>
                <td>{cliente.endereco.cidade}</td>
              
              <td>
                <button className='btn btn-danger' >Deletar</button>
                <button className='btn btn-warning' >Atualizar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    
  )
}

export default TabelaCliente