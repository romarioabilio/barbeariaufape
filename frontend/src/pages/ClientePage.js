import React, { useState, useEffect } from 'react';
import FormularioCliente from '../components/Clientes/FormularioCliente';
import TabelaCliente from '../components/Clientes/TabelaCliente';
import { Link } from 'react-router-dom';

const ClientePage = () => {
  const clienteInicial = {
    nome: '',
    cpf: '',
    telefone: '',
    email: '',
    dataNascimento: '',
    endereco: {
      rua: '',
      numero: '',
      bairro: '',
      cidade: '',
      estado: '',
      cep: '',
    },
  };

  const [btnCadastrarCliente, setBtnCadastrarCliente] = useState(true);
  const [clientes, setClientes] = useState([]);
  const [clienteAtual, setClienteAtual] = useState(clienteInicial);

  useEffect(() => {
    fetch("http://localhost:8080/listarCliente")
      .then((retorno) => retorno.json())
      .then((retorno_convertido) => setClientes(retorno_convertido));
  }, []);

  const aoDigitar = (e) => {
    setClienteAtual({...clienteAtual, [e.target.name]:e.target.value});
  };
  const aoDigitarEndereco = (e) => {
    setClienteAtual({...clienteAtual, endereco: {...clienteAtual.endereco, [e.target.name]:e.target.value}});
  };

  const limparFormulario = () => {
    setClienteAtual(clienteInicial);
    setBtnCadastrarCliente(true);
  };

  const selecionarCliente = (indice) => {
    setClienteAtual(clientes[indice]);
    setBtnCadastrarCliente(false);
  };

  const cadastrar = () => {
    // Verificar campos obrigatórios
    if (clienteAtual.nome.trim() === '' || clienteAtual.cpf.trim() === '') {
      alert("Por favor, preencha os campos obrigatórios.");
      return;
    }

    fetch("http://localhost:8080/adicionarCliente", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json",
      },
      body: JSON.stringify(clienteAtual)
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Erro ao cadastrar cliente.");
      }
      return response.json();
      })
      .then(retorno_convertido =>{
        setClientes([...clientes, retorno_convertido]);
        alert("Cliente cadastrado com Sucesso !")
        limparFormulario();
        
      })
      .catch((error) => {
        console.error("Erro:", error);
      });
  };

  const remover = () => {
    const confirmacao = window.confirm("Tem certeza que deseja remover o cliente?");
    if (!confirmacao) {
      return; // Cancela a remoção se o usuário não confirmar
    }
  
    fetch("http://localhost:8080/deletarClienteId/" + clienteAtual.id, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      }
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Erro ao remover cliente.');
      }
      const vetorTemp = clientes.filter(p => p.id !== clienteAtual.id);
      setClientes(vetorTemp);
      limparFormulario();
      alert("Cliente removido com sucesso!");
    })
    .catch(error => {
      console.error('Erro:', error);
      // Trate o erro aqui, se necessário
    });
  }

  const alterar = () => {
    fetch("http://localhost:8080/atualizarCliente/" + clienteAtual.id, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
      body: JSON.stringify(clienteAtual)
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Erro ao atualizar cliente.');
      }
      return response.json(); // Retornar o JSON da resposta
    })
    .then(atualizado => {
      const vetorTemp = clientes.map(p => {
        if (p.id === clienteAtual.id) {
          return atualizado; // Usar o serviço atualizado
        }
        return p;
      });
      setClientes(vetorTemp);
      limparFormulario();
      alert("Cliente alterado com sucesso!");
    })
    .catch(error => {
      console.error('Erro:', error);
      // Trate o erro aqui, se necessário
    });
  }
    

  // Funções para atualizar e remover são semelhantes às do código anterior

  return (
    <div>
      <FormularioCliente
        botao={btnCadastrarCliente}
        eventoTeclado={aoDigitar}
        eventoTecladoEndereco={aoDigitarEndereco}
        cadastrar={cadastrar}
        cancelar={limparFormulario}
        obj={clienteAtual}
        remover={remover}
        alterar={alterar}
      />
      <TabelaCliente vetor={clientes} selecionar={selecionarCliente} />
      <nav>
      <ul>
        <li>
        <button>
          <Link to="/">Ir para a página inicial</Link>
        </button>
        </li>
      </ul>
    </nav>

    </div>
  );
};

export default ClientePage;
