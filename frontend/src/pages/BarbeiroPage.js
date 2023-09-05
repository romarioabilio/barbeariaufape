import React, { useState, useEffect } from 'react';
import FormularioBrabeiro from '../components/Barbeiros/FormularioBarbeiro';
import TabelaBarbeiro from '../components/Barbeiros/TabelaBarbeiro';
import { Link } from 'react-router-dom';

const BarbeiroPage = () => {
  const barbeiroInicial = {
    nome: '',
    cpf: '',
    telefone: '',
    email: '',
    dataNascimento: '',
    especialidade: '',
    salario: '',
    endereco: {
      rua: '',
      numero: '',
      bairro: '',
      cidade: '',
      estado: '',
      cep: '',
    },
    
  };

  const [btnCadastrarBarbeiro, setBtnCadastrarBarbeiro] = useState(true);
  const [barbeiros, setBarbeiros] = useState([]);
  const [barbeiroAtual, setBarbeiroAtual] = useState(barbeiroInicial);

  useEffect(() => {
    fetch("http://localhost:8080/listarBarbeiro")
      .then((retorno) => retorno.json())
      .then((retorno_convertido) => setBarbeiros(retorno_convertido));
  }, []);

  const aoDigitar = (e) => {
    if (e.target.name === 'cpf' || e.target.name === 'telefone') {
      // Remove todos os caracteres não numéricos
      const valorNumerico = e.target.value.replace(/\D/g, '');

      // Limita o campo a 11 dígitos (CPF, telefone)
      if (valorNumerico.length > 11) {
        return;
      }
       // Formata CPF com pontos e traços
       if (e.target.name === 'cpf' && valorNumerico.length === 11) {
        const cpfFormatado = `${valorNumerico.substring(0, 3)}.${valorNumerico.substring(3, 6)}.${valorNumerico.substring(6, 9)}-${valorNumerico.substring(9)}`;
        setBarbeiroAtual({ ...barbeiroAtual, [e.target.name]: cpfFormatado });
      } else if (e.target.name === 'telefone' && valorNumerico.length >= 10) {
        const ddd = valorNumerico.substring(0, 2);
        const primeiroGrupo = valorNumerico.substring(2, 7);
        const segundoGrupo = valorNumerico.substring(7);
        const telefoneFormatado = `(${ddd}) ${primeiroGrupo}-${segundoGrupo}`;
        setBarbeiroAtual({ ...barbeiroAtual, [e.target.name]: telefoneFormatado });
      } else {
        setBarbeiroAtual({ ...barbeiroAtual, [e.target.name]: valorNumerico });
      }
    } else {
      setBarbeiroAtual({ ...barbeiroAtual, [e.target.name]: e.target.value });
    }
  };
  const aoDigitarEndereco = (e) => {
    if (e.target.name === 'cep') {
      // Remove todos os caracteres não numéricos
      const cepNumerico = e.target.value.replace(/\D/g, '');

      // Limita o CEP a 8 dígitos
      if (cepNumerico.length > 8) {
        return;
      }

      // Adiciona o hífen após o quinto dígito
      let cepFormatado = cepNumerico;
      if (cepNumerico.length > 5) {
        cepFormatado = `${cepNumerico.slice(0, 5)}-${cepNumerico.slice(5)}`;
      }

      setBarbeiroAtual({ ...barbeiroAtual, endereco: { ...barbeiroAtual.endereco, cep: cepFormatado } });
    } else {
      setBarbeiroAtual({ ...barbeiroAtual, endereco: { ...barbeiroAtual.endereco, [e.target.name]: e.target.value } });
    }
  };

  const limparFormulario = () => {
    setBarbeiroAtual(barbeiroInicial);
    setBtnCadastrarBarbeiro(true);
  };

  const selecionarBarbeiro = (indice) => {
    setBarbeiroAtual(barbeiros[indice]);
    setBtnCadastrarBarbeiro(false);
  };

  const cadastrar = () => {
    // Verificar campos obrigatórios
    if (barbeiroAtual.nome.trim() === '' || barbeiroAtual.cpf.trim() === '') {
      alert("Por favor, preencha os campos obrigatórios.");
      return;
    }

    fetch("http://localhost:8080/adicionarBarbeiro", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json",
      },
      body: JSON.stringify(barbeiroAtual)
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Erro ao cadastrar barbeiro.");
      }
      return response.json();
      })
      .then(retorno_convertido =>{
        setBarbeiros([...barbeiros, retorno_convertido]);
        alert("Barbeiro cadastrado com Sucesso !")
        limparFormulario();
        
      })
      .catch((error) => {
        console.error("Erro:", error);
      });
  };

  const remover = () => {
    const confirmacao = window.confirm("Tem certeza que deseja remover o barbeiro?");
    if (!confirmacao) {
      return; // Cancela a remoção se o usuário não confirmar
    }
  
    fetch("http://localhost:8080/deletarBarbeiroId/" + barbeiroAtual.id, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      }
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Erro ao remover barbeiro.');
      }
      const vetorTemp = barbeiros.filter(p => p.id !== barbeiroAtual.id);
      setBarbeiros(vetorTemp);
      limparFormulario();
      alert("Barbeiro removido com sucesso!");
    })
    .catch(error => {
      console.error('Erro:', error);
      // Trate o erro aqui, se necessário
    });
  }

  const alterar = () => {
    fetch("http://localhost:8080/atualizarBarbeiro/" + barbeiroAtual.id, {
      method: "PATCH",
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
      body: JSON.stringify(barbeiroAtual)
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Erro ao atualizar barbeiro.');
      }
      return response.json(); // Retornar o JSON da resposta
    })
    .then(atualizado => {
      const vetorTemp = barbeiros.map(p => {
        if (p.id === barbeiroAtual.id) {
          return atualizado; // Usar o serviço atualizado
        }
        return p;
      });
      setBarbeiros(vetorTemp);
      limparFormulario();
      alert("Barbeiro alterado com sucesso!");
    })
    .catch(error => {
      console.error('Erro:', error);
      // Trate o erro aqui, se necessário
    });
  }
    

  // Funções para atualizar e remover são semelhantes às do código anterior

  return (
    <div>
      <FormularioBrabeiro
        botao={btnCadastrarBarbeiro}
        eventoTeclado={aoDigitar}
        eventoTecladoEndereco={aoDigitarEndereco}
        cadastrar={cadastrar}
        cancelar={limparFormulario}
        obj={barbeiroAtual}
        remover={remover}
        alterar={alterar}
      />
      <TabelaBarbeiro vetor={barbeiros} selecionar={selecionarBarbeiro} />
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

export default BarbeiroPage;
