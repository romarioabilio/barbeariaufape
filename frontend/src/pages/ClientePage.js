import React, { useState, useEffect } from 'react';
import axios from 'axios';
import TabelaCliente from '../components/Clientes/TabelaCliente';

const ClientePage = () => {
  const [clientes, setClientes] = useState([]);
  const [nome, setNome] = useState('');
  const [cpf, setCpf] = useState('');
  const [telefone, setTelefone] = useState('');
  const [email, setEmail] = useState('');
  const [rua, setRua] = useState('');
  const [bairro, setBairro] = useState('');
  const [estado, setEstado] = useState('');
  const [cep, setCep] = useState('');
  const [numero, setNumero] = useState('');
  const [cidade, setCidade] = useState('');
  const [vip, setVip] = useState(false);

  const baseURL = 'http://localhost:8080'; // Altere para a URL do seu servidor backend
  const axiosInstance = axios.create({
    baseURL: baseURL,
  });

  const fetchClientes = async () => {
    try {
      const response = await axiosInstance.get('/listarCliente'); // Certifique-se de que a rota esteja correta
      setClientes(response.data);
    } catch (error) {
      console.error('Erro ao buscar clientes:', error);
    }
  };
  

  const handleSubmit = async (event) => {
    event.preventDefault();
    const novoCliente = {
      nome,
      cpf,
      telefone,
      endereco: {
        rua,
        bairro,
        estado,
        cep,
        numero,
        cidade,
      },
      vip,
    };

    try {
      await axios.post('/adicionarCliente', novoCliente); // Verifique se a URL está correta
      fetchClientes();
      // Limpar campos após a adição bem-sucedida
      setNome('');
      setCpf('');
      setTelefone('');
      setEmail('');
      setRua('');
      setBairro('');
      setEstado('');
      setCep('');
      setNumero('');
      setCidade('');
      setVip(false);
    } catch (error) {
      console.error('Erro ao adicionar cliente:', error);
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`/deletarClienteId/${id}`); // Verifique se a URL está correta
      fetchClientes();
    } catch (error) {
      console.error('Erro ao deletar cliente:', error);
    }
  };
  const handleUpdate = async (id) => {
    const clienteToUpdate = clientes.find((cliente) => cliente.id === id);
    if (!clienteToUpdate) {
      console.error('Cliente não encontrado para atualização.');
      return;
    }
  
    try {
      // Implemente o código aqui para exibir um formulário de atualização
      // e enviar as informações atualizadas para o backend
      // Você pode usar o mesmo padrão de handleSubmit
      // Lembre-se de passar as informações atuais do cliente para o formulário
    } catch (error) {
      console.error('Erro ao atualizar cliente:', error);
    }
  };

  useEffect(() => {
    fetchClientes();
  }, []);

  return (
    <div>
    <h1>Clientes</h1>
    <form onSubmit={handleSubmit} clientes={clientes}>
      <h2>Cadastrar Novo Cliente</h2>
      {/* ... campos do formulário de cadastro ... */}
      <button className='btn btn-success' type="submit">Cadastrar</button>
    </form>
    <TabelaCliente  clientes={clientes}/>
  </div>
  );
};

export default ClientePage;
