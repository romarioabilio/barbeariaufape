import React from 'react'
import Formulario from '../components/Produtos/FormularioProduto';
import Tabela from '../components/Produtos/TabelaProduto';
import  { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';



const ProdutoPage = () => {

    const produto = {
        nome: '',
        preco: '',
        descricao: '',
        quantidade: ''
    
      }
      const [btnCadastrar,setBtnCadastrar] = useState(true)
      const [produtos,setProdutos] = useState([])
      const [objProduto,setObjProduto] = useState(produto)
    
      useEffect(()=>{
        fetch("http://localhost:8080/listarProdutos")
        .then((retorno)=>retorno.json())
        .then(retorno_convertido => setProdutos(retorno_convertido))
      }
      ,[])
    
      const aoDigitar = (e) => {
        setObjProduto({...objProduto,[e.target.name]:e.target.value})
      }
    
     
      const limparFormulario = () => {
        setObjProduto(produto)
        setBtnCadastrar(true)
      }
    
      const selecionarProduto = (indice) => {
        setObjProduto(produtos[indice])
        setBtnCadastrar(false)
      }
    
      const cadastrar = () => {
        // Verificar se os campos obrigatórios não estão em branco
        if (objProduto.nome.trim() === '' || objProduto.preco.trim() === '') {
          alert("Por favor, preencha os campos obrigatórios.");
          return; // Não faz a requisição se os campos estão em branco
        }
      
        fetch("http://localhost:8080/salvarProduto", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
          },
          body: JSON.stringify(objProduto)
        })
        .then(response => {
          if (!response.ok) {
            throw new Error('Erro ao cadastrar produto.');
          }
          return response.json();
        })
        .then(retorno_convertido => {
          setProdutos([...produtos, retorno_convertido]);
          alert("Produto cadastrado com sucesso!");
          limparFormulario();
        })
        .catch(error => {
          console.error('Erro:', error);
          // Trate o erro aqui, se necessário
        });
      }
      
    
    
      const remover = () => {
        const confirmacao = window.confirm("Tem certeza que deseja remover o produto?");
        if (!confirmacao) {
          return; // Cancela a remoção se o usuário não confirmar
        }
      
        fetch("http://localhost:8080/removerProduto/" + objProduto.id, {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
          }
        })
        .then(response => {
          if (!response.ok) {
            throw new Error('Erro ao remover produto.');
          }
          const vetorTemp = produtos.filter(p => p.id !== objProduto.id);
          setProdutos(vetorTemp);
          limparFormulario();
          alert("Produto removido com sucesso!");
        })
        .catch(error => {
          console.error('Erro:', error);
          // Trate o erro aqui, se necessário
        });
      }
      
    
      const alterar = () => {
        fetch("http://localhost:8080/atualizarProduto", {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
          },
          body: JSON.stringify(objProduto)
        })
        .then(response => {
          if (!response.ok) {
            throw new Error('Erro ao atualizar produto.');
          }
          return response.json(); // Retornar o JSON da resposta
        })
        .then(atualizado => {
          const vetorTemp = produtos.map(p => {
            if (p.id === objProduto.id) {
              return atualizado; // Usar o produto atualizado
            }
            return p;
          });
          setProdutos(vetorTemp);
          limparFormulario();
          alert("Produto alterado com sucesso!");
        })
        .catch(error => {
          console.error('Erro:', error);
          // Trate o erro aqui, se necessário
        });
      }
        
        
        
        

  return (
    <div>
        <Formulario botao={btnCadastrar} eventoTeclado={aoDigitar}  cadastrar={cadastrar} cancelar={limparFormulario} obj={objProduto} remover={remover} alterar={alterar}/>
        <Tabela vetor={produtos} selecionar={selecionarProduto}/>

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

export default ProdutoPage