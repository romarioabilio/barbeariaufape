import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ProdutoPage from './pages/ProdutoPage';
import ServicoPage from './pages/ServicoPage';
import ClientePage from './pages/ClientePage';
import LoginPage from './pages/LoginPage';
import BarbeiroPage from './pages/BarbeiroPage';

import AgendamentoPage from './pages/AgendamentoPage';
import NovoAgendamento from './components/Agendamentos/NovoAgendamento';
import TabelaAgendamento from './components/Agendamentos/TabelaAgendamento';


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
          <Route path="/NovoAgendamento" element={<NovoAgendamento />} />
          <Route path="/TabelaAgendamento" element={<TabelaAgendamento />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
