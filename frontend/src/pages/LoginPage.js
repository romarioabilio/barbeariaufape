import React from 'react'
import { Link } from 'react-router-dom';
import './LoginPage.css'
import {
  MDBContainer,
  MDBInput,
  MDBCheckbox,
  MDBBtn,
  MDBIcon
}
from 'mdb-react-ui-kit';

const LoginPage = () => {
  return (
    
    <div>
    <nav>
        <h1>Barbearia UFAPE</h1>
        
      <ul>
        <li>
          <Link to="/Produtos">Produtos</Link>
        </li>
        <li>
          <Link to="/Servicos">Serviços</Link>
        </li>
        <li>
          <Link to="/Clientes">Clientes</Link>
        </li>
        <li> 
          <Link to="/Barbeiros">Barbeiros</Link>
        </li>
      </ul>
      
      
    </nav>
  
    <MDBContainer className="p-3 my-5 d-flex flex-column w-50">

      <MDBInput wrapperClass='mb-4' label='E-mail' id='form1' type='email'/>
      <MDBInput wrapperClass='mb-4' label='Senha' id='form2' type='password'/>

      <div className="d-flex justify-content-between mx-3 mb-4">
        <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Lembre-me' />
        <a href="!#"></a>
      </div>

      <MDBBtn className="mb-4">Entrar</MDBBtn>

      <div className="text-center">
        <p>Não é um usúario ? <a href="http://localhost:3000/Clientes">Cadastre-se</a></p>
        <div className='d-flex justify-content-between mx-auto' style={{width: '40%'}}>
          <MDBBtn tag='a' color='none' className='m-1' style={{ color: '#1266f1' }}>
            <MDBIcon fab icon='facebook-f' size="sm"/>
          </MDBBtn>

          <MDBBtn tag='a' color='none' className='m-1' style={{ color: '#1266f1' }}>
            <MDBIcon fab icon='twitter' size="sm"/>
          </MDBBtn>

          <MDBBtn tag='a' color='none' className='m-1' style={{ color: '#1266f1' }}>
            <MDBIcon fab icon='google' size="sm"/>
          </MDBBtn>

          <MDBBtn tag='a' color='none' className='m-1' style={{ color: '#1266f1' }}>
            <MDBIcon fab icon='github' size="sm"/>
          </MDBBtn>

        </div>
      </div>

    </MDBContainer>
 



    </div>
  );
}

export default LoginPage