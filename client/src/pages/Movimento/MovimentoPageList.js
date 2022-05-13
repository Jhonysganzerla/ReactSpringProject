import React, { useEffect, useState } from "react";
import MovimentoService from "../../services/Conta/movimento.service";

const MovimentoPageList = () => {

    const [data, setData] = useState([]);
    const [apiError, setApiError] = useState(null);

    useEffect(() => {

        loadData();
        
    }, []);

    const loadData = () => {
        MovimentoService.findAll().then(response => {
            setData(response.data);
            setApiError(null);
        }).catch((error) => {
            setApiError(error.response.data.message);
        });
    }

    return (
        <div className="container">
            <h1 className="tex-center">Lista de Movimentos</h1>

            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Valor</th>
                        <th>Descricao</th>
                        <th>Data de Vencimento</th>
                        <th>Data de Pagamento</th>
                        <th>Valor Pago</th>
                        <th>Valor</th>
                        <th>Categoria</th>
                        <th>Movimento Conta</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map(item => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.valor}</td>
                            <td>{item.descricao}</td>
                            <td>{item.dataVencimento}</td>
                            <td>{item.dataPagamento}</td>
                            <td>{item.valorpago}</td>
                            <td>{item.valor}</td>
                            <td>{item.categoria}</td>
                            <td>{item.movimentotipo}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );

};
export default MovimentoPageList;