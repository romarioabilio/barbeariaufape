import React from 'react'



const FormularioBarbeiro = ({botao,eventoTeclado,cadastrar,cancelar,obj,remover,alterar,eventoTecladoEndereco}) => {
  return (
    <div>
        <h2>Cadastro de Barbeiros</h2>
        <form >
            <input type="text" value={obj.nome} onChange={eventoTeclado} name='nome' placeholder='Nome' className='form-control'/>
            <input type="text" value={obj.cpf} onChange={eventoTeclado} name='cpf' placeholder='CPF' className='form-control' />
            <input type="text" value={obj.telefone} onChange={eventoTeclado} name='telefone' placeholder='Telefone' className='form-control' />
            <input type="text" value={obj.email} onChange={eventoTeclado} name='email' placeholder='Email' className='form-control'/>
            <input type="date" value={obj.dataNascimento} onChange={eventoTeclado} name='dataNascimento' placeholder='Data de Nascimento' className='form-control'/>
            <input type="text" value={obj.especialidade} onChange={eventoTeclado} name='especialidade' placeholder='Especialidade' className='form-control'/>
            <input type="text" value={obj.salario} onChange={eventoTeclado} name='salario' placeholder='Salário' className='form-control'/>
            <input type="text" value={obj.endereco.estado} onChange={(e) => eventoTecladoEndereco(e, 'estado')} name='estado' placeholder='Estado' className='form-control'/>
            <input type="text" value={obj.endereco.cidade} onChange={(e) => eventoTecladoEndereco(e, 'cidade')} name='cidade' placeholder='Cidade' className='form-control'/>
            <input type="text" value={obj.endereco.cep} onChange={(e) => eventoTecladoEndereco(e, 'cep')} name='cep' placeholder='CEP' className='form-control'/>
            <input type="text" value={obj.endereco.bairro} onChange={(e) => eventoTecladoEndereco(e, 'bairro')} name='bairro' placeholder='Bairro' className='form-control'/>
            <input type="text" value={obj.endereco.rua} onChange={(e) => eventoTecladoEndereco(e, 'rua')} name='rua' placeholder='Rua' className='form-control'/>
            <input type="text" value={obj.endereco.numero} onChange={(e) => eventoTecladoEndereco(e, 'numero')} name='numero' placeholder='Número' className='form-control'/>
            
          
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
  )
}

export default FormularioBarbeiro