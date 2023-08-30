import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ProdutoPage from './pages/ProdutoPage';
import ServicoPage from './pages/ServicoPage';


function App() {
  return (
    <BrowserRouter>
      <div>
        <h1>Barbearia UFAPE</h1>
        <Routes>
          <Route path="/Servicos" element={<ServicoPage />} />
          <Route path="/Produtos" element={<ProdutoPage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
