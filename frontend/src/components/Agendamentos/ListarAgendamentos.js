import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './NovoAgendamento.css';
import TabelaListar from './TabelaListar';

function ListarAgendamentos() {
  const agendamentoInicial = {
    cliente: {},
    barbeiro: {},
    servicos: [],
    data: '',
    hora: '',
    observacao: '',
  };
  const [agendamentos, setAgendamentos] = useState([]);
  const [agendamentoAtual, setAgendamentoAtual] = useState(agendamentoInicial);
  const [clientes, setClientes] = useState([]);
  const [cliente, setCliente] = useState(0);
  const [barbeiros, setBarbeiros] = useState([]);
  const [barbeiro, setBarbeiro] = useState(0);
  const [servicos, setServicos] = useState([]);
  const [servicosSelecionados, setServicosSelecionados] = useState([]);
  const [data, setData] = useState('');
  const [hora, setHora] = useState('');
  const [observacao, setObservacao] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/listarCliente')
      .then(response => {
        setClientes(response.data);
      })
      .catch(error => {
        console.error(error);
      });

    axios.get('http://localhost:8080/listarBarbeiro')
      .then(response => {
        setBarbeiros(response.data);
      })
      .catch(error => {
        console.error(error);
      });

    axios.get('http://localhost:8080/listarServicos')
      .then(response => {
        setServicos(response.data);
      })
      .catch(error => {
        console.error(error);
      });

    fetch('http://localhost:8080/listarAgendamentos')
      .then((retorno) => retorno.json())
      .then((retorno_convertido) => {
        setAgendamentos(retorno_convertido);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  useEffect(() => {
    console.log(cliente)
  }, [cliente])

  const handleServicoSelection = (e) => {
    const servicoId = Number(e.target.value);

    if (e.target.checked) {
      // Se a caixa de seleção estiver marcada, adiciona o serviço aos selecionados
      setServicosSelecionados([...servicosSelecionados, { id: servicoId }]);
    } else {
      // Se a caixa de seleção estiver desmarcada, remove o serviço dos selecionados
      setServicosSelecionados(servicosSelecionados.filter((s) => s.id !== servicoId));
    }
  };

  const [btnCadastrarAgendamento, setBtnCadastrarAgendamento] = useState(true);

  const limparFormulario = () => {
    setCliente('');
    setBarbeiro('');
    setServicosSelecionados([]);
    setData('');
    setHora('');
    setObservacao('');
    setBtnCadastrarAgendamento(true);
  };

  const selecionarAgendamento = (indice) => {
    setAgendamentoAtual(agendamentos[indice]);
    setBtnCadastrarAgendamento(false);
  };

  const handleSubmit = e => {
    e.preventDefault();

    if (!cliente || !barbeiro || servicosSelecionados.length === 0) {
      return; // Certifique-se de que os três itens foram selecionados
    }

    const newAgendamento = {
      cliente: { id: Number(cliente) },
      barbeiro: { id: Number(barbeiro) },
      servicos: servicosSelecionados,
      data,
      hora,
      observacao
    };

    console.log(newAgendamento, cliente, barbeiro);

    axios.post('http://localhost:8080/novoAgendamento', newAgendamento)
      .then(response => {
        console.log(response.data);
        fetch('http://localhost:8080/listarAgendamentos')
          .then((retorno) => retorno.json())
          .then((retorno_convertido) => {
            setAgendamentos(retorno_convertido);
            limparFormulario(); // Mova a chamada aqui para manter a seleção de serviços até que a lista de agendamentos seja atualizada.
          })
          .catch((error) => {
            console.error(error);
          });
      })
      .catch(error => {
        console.error(error);
      });
  };
  return (
    <div>
      <TabelaListar vetor={agendamentos} selecionar={selecionarAgendamento} />
    </div>
  );
}

export default ListarAgendamentos;