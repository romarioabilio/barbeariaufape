import React from 'react'
import { useState, useEffect } from 'react';


function TabelaServico ({vetor,selecionar}){
  const [termoPesquisa, setTermoPesquisa] = useState('');

  const filtroServico = vetor.filter((servico) =>
    servico.nome.toLowerCase().includes(termoPesquisa.toLowerCase())
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
                    <th>Descrição</th>
                    <th>Preço</th>
                    <th>Selecionar</th>
                </tr>
            </thead>
            <tbody>
              {
                filtroServico.map((obj,indice)=>(

                    <tr key={indice}>
                        <td>{indice+1}</td>
                        <td>{obj.nome}</td>
                        <td>{obj.descricao}</td>
                        <td>R${obj.preco.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</td>
                        <td><button onClick={()=>{selecionar(indice)}} className='btn btn-success'>Selecionar</button></td>
                    </tr>
                ))
              }
            </tbody>
        </table>
        </div>
    
  )
}

export default TabelaServico