import React from 'react'
import { useState, useEffect } from 'react';
function TabelaProduto ({vetor,selecionar}){
  const [termoPesquisa, setTermoPesquisa] = useState('');

  const filtroProdutos = vetor.filter((produto) =>
    produto.nome.toLowerCase().includes(termoPesquisa.toLowerCase())
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
                filtroProdutos.map((obj,indice)=>(
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
        </div>
    
  )
}

export default TabelaProduto