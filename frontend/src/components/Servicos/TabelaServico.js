import React from 'react'
import { useState, useEffect } from 'react';


function TabelaServico ({vetor,selecionar}){
  return (
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
                vetor.map((obj,indice)=>(

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
    
  )
}

export default TabelaServico