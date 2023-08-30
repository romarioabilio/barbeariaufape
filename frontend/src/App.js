import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ProdutoPage from './pages/ProdutoPage';
import ServicoPage from './pages/ServicoPage';
import ClientePage from './pages/ClientePage';
import HomePage from './pages/HomePage';


function App() {
  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path="/Home" element={<HomePage />} />
          <Route path="/Servicos" element={<ServicoPage />} />
          <Route path="/Produtos" element={<ProdutoPage />} />
          <Route path="/Clientes" element={<ClientePage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
