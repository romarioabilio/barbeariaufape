import React from 'react'
import { Link } from 'react-router-dom';
import './HomePage.css'

const HomePage = () => {
  return (
    
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
      </ul>
    </nav>
  );
}

export default HomePage