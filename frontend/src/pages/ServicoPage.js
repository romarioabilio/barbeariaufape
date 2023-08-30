import React from 'react'
import Formulario from '../components/Servicos/FormularioServico';
import Tabela from '../components/Servicos/TabelaServico';
import  { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

const ServicoPage = () => {

    const servico = {
        nome: '',
        descricao: '',
        preco: ''
    
      }
      const [btnCadastrarServico,setBtnCadastrarServico] = useState(true)
      const [servicos,setServicos] = useState([])
      const [objServico,setObjServico] = useState(servico)
    
      useEffect(()=>{
        fetch("http://localhost:8080/listarServicos")
        .then((retorno)=>retorno.json())
        .then(retorno_convertido => setServicos(retorno_convertido))
      }
      ,[])
    
      const aoDigitar = (e) => {
        setObjServico({...objServico,[e.target.name]:e.target.value})
      }
    
     
      const limparFormulario = () => {
        setObjServico(servico)
        setBtnCadastrarServico(true)
      }
    
      const selecionarServico = (indice) => {
        setObjServico(servicos[indice])
        setBtnCadastrarServico(false)
      }
    
      const cadastrar = () => {
        // Verificar se os campos obrigatórios não estão em branco
        if (objServico.nome.trim() === '' || objServico.preco.trim() === '') {
          alert("Por favor, preencha os campos obrigatórios.");
          return; // Não faz a requisição se os campos estão em branco
        }
      
        fetch("http://localhost:8080/salvarServico", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
          },
          body: JSON.stringify(objServico)
        })
        .then(response => {
          if (!response.ok) {
            throw new Error('Erro ao cadastrar serviço.');
          }
          return response.json();
        })
        .then(retorno_convertido => {
          setServicos([...servicos, retorno_convertido]);
          alert("Serviço cadastrado com sucesso!");
          limparFormulario();
        })
        .catch(error => {
          console.error('Erro:', error);
          // Trate o erro aqui, se necessário
        });
      }
      
    
    
      const remover = () => {
        const confirmacao = window.confirm("Tem certeza que deseja remover o serviço?");
        if (!confirmacao) {
          return; // Cancela a remoção se o usuário não confirmar
        }
      
        fetch("http://localhost:8080/removerServico/" + objServico.id, {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
          }
        })
        .then(response => {
          if (!response.ok) {
            throw new Error('Erro ao remover serviço.');
          }
          const vetorTemp = servicos.filter(p => p.id !== objServico.id);
          setServicos(vetorTemp);
          limparFormulario();
          alert("Serviço removido com sucesso!");
        })
        .catch(error => {
          console.error('Erro:', error);
          // Trate o erro aqui, se necessário
        });
      }
      
    
      const alterar = () => {
        fetch("http://localhost:8080/atualizarServico", {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
          },
          body: JSON.stringify(objServico)
        })
        .then(response => {
          if (!response.ok) {
            throw new Error('Erro ao atualizar serviço.');
          }
          return response.json(); // Retornar o JSON da resposta
        })
        .then(atualizado => {
          const vetorTemp = servicos.map(p => {
            if (p.id === objServico.id) {
              return atualizado; // Usar o serviço atualizado
            }
            return p;
          });
          setServicos(vetorTemp);
          limparFormulario();
          alert("Serviço alterado com sucesso!");
        })
        .catch(error => {
          console.error('Erro:', error);
          // Trate o erro aqui, se necessário
        });
      }
        
        
        
        

  return (
    <div>
        <Formulario 
        botao={btnCadastrarServico} 
        eventoTeclado={aoDigitar}  
        cadastrar={cadastrar} 
        cancelar={limparFormulario} 
        obj={objServico} 
        remover={remover} 
        alterar={alterar}
        />
        <Tabela vetor={servicos} selecionar={selecionarServico}/>
        <nav>
      <ul>
        <li>
          <Link to="/Home">Voltar a Página inicial </Link>
        </li>
      </ul>
    </nav>
    </div>
  )
}

export default ServicoPage