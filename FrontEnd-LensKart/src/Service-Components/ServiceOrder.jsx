import axios from 'axios';

const Backend_API = "http://localhost:8083/orders";

export const axiosGetOrdersByCustId = async (id) => {
    id = id || '';
    return await axios.get(Backend_API + '/findBycustId/' + id);
}

export const axiosPlaceOrder = async (custid) => {
    return await axios.post(Backend_API + '/placeOrder/' + custid);
}

export const axiosGetItemsOrderId = async (id) => {
    id = id || '';
    return await axios.get(Backend_API + '/find/' + id);
}
export const axiosGetAllOrders = async (id) => {
    id = id || '';
    return await axios.get(Backend_API + '/findall/' + id);
}