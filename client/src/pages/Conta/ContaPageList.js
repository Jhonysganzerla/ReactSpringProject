import React, { useEffect, useState } from "react";
import ContaService from "../../services/Conta/conta.service";

const ContaPageList = () => {

    const [data, setData] = useState([]);
    const [apiError, setApiError] = useState(null);

    useEffect(() => {

        loadData();
        
    }, []);

    const loadData = () => {
        ContaService.findAll().then(response => {
            setData(response.data);
            setApiError(null);
        }).catch(error => {
            setApiError(error.response.data.error);
        });
    }

    return (
        <div className="container">
            <h1 className="tex-center">Lista de Contas</h1>

            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Numero</th>
                        <th>Agencia</th>
                        <th>Banco</th>
                        <th>Tipo</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map(item => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.numero}</td>
                            <td>{item.agencia}</td>
                            <td>{item.banco}</td>
                            <td>{item.tipo}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );

};
export default ContaPageList;