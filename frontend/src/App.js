import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ProdutoPage from './pages/ProdutoPage';
import ServicoPage from './pages/ServicoPage';
import ClientePage from './pages/ClientePage';
import LoginPage from './pages/LoginPage';
import BarbeiroPage from './pages/BarbeiroPage';


function App() {
  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path="/" element={<LoginPage />} />
          <Route path="/Servicos" element={<ServicoPage />} />
          <Route path="/Produtos" element={<ProdutoPage />} />
          <Route path="/Clientes" element={<ClientePage />} />
          <Route path="/Barbeiros" element={<BarbeiroPage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
