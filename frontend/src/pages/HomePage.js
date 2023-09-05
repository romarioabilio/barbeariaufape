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
          <Link to="/Agendamentos">Agendamentos</Link>
        </li>
        <li>
          <Link to="/Atendimentos">Atendimentos</Link>
        </li>
      </ul>
      
      
    </nav>
  
    <footer className="rodape">
        <div className="contact-info">
          <h2>Localização:</h2>
          <p>Av. Bom Pastor, s/n - Boa Vista, 55292-270</p>
          <p>Garanhuns - PE</p>

          <h2>Contato:</h2>
          <p>Email: info@barbeariaufape.com</p>
          <p>Telefone: (81) 23456-7890</p>
        </div>
      </footer>
    </div>
  );
}

export default HomePage