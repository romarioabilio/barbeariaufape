import React from 'react'

function Tabela ({vetor,selecionar}){
  return (
        <table className='table'>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Selecionar</th>
                </tr>
            </thead>
            <tbody>
              {
                vetor.map((obj,indice)=>(
                    <tr key={indice}>
                        <td>{indice+1}</td>
                        <td>{obj.nome}</td>
                        <td>R${obj.preco.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</td>
                        <td>{obj.descricao}</td>
                        <td>{obj.quantidade}</td>
                        <td><button onClick={()=>{selecionar(indice)}} className='btn btn-success'>Selecionar</button></td>
                    </tr>
                ))
              }
            </tbody>
        </table>
    
  )
}

export default Tabela