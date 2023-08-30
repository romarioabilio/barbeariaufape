import React from 'react'
import './FormularioServico.css'
import  { useState, useEffect } from 'react';

function FormularioServico ({botao,eventoTeclado,cadastrar,cancelar,obj,remover,alterar})  {
  return (
    <div>
        <h2>Cadastro de Serviços</h2>
        <form >
            <input type="text" value={obj.nome} onChange={eventoTeclado} name='nome' placeholder='Nome' className='form-control'/>
            <input type="text" value={obj.descricao} onChange={eventoTeclado} name='descricao' placeholder='Descrição' className='form-control' />
            <input type="text" value={obj.preco} onChange={eventoTeclado} name='preco' placeholder='Preço' className='form-control'/>

            {
                botao
                ?
                <input type="button" value='Cadastrar' onClick={cadastrar} className='btn btn-primary'/>
                :
                <div>
                    <input type="button" value='Alterar' className='btn btn-warning' onClick={alterar} />
                    <input type="button" value="Remover" className='btn btn-danger' onClick={remover}/>
                    <input type="button" value="Cancelar" className='btn btn-secondary' onClick={cancelar}/>
                </div>
            }
        </form>
    </div>
    
  );
}

export default FormularioServico