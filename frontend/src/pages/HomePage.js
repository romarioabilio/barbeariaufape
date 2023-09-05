import React from 'react'
import { Link } from 'react-router-dom';
import './HomePage.css'


const HomePage = () => {
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
        <li>
          <Link to="/Agendamento">Agendamentos</Link>
        </li>
        <li>
          <Link to="/Atendimento">Atendimentos</Link>
        </li>
      </ul>
      
      
    </nav>
  
   



    </div>
  );
}

export default HomePage