import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ProdutoPage from './pages/ProdutoPage';
import ServicoPage from './pages/ServicoPage';
import ClientePage from './pages/ClientePage';
import HomePage from './pages/HomePage';
import BarbeiroPage from './pages/BarbeiroPage';
import NovoAgendamento from './components/Agendamentos/NovoAgendamento';
import NovoAtendimento from './components/Atendimentos/NovoAtendimento';

function App() {
  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/Servicos" element={<ServicoPage />} />
          <Route path="/Produtos" element={<ProdutoPage />} />
          <Route path="/Clientes" element={<ClientePage />} />
          <Route path="/Barbeiros" element={<BarbeiroPage />} />
          <Route path="/Agendamento" element={<NovoAgendamento />} />
          <Route path="/Atendimento" element={<NovoAtendimento />} />
         
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
