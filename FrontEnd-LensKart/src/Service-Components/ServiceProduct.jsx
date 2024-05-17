import axios from 'axios';

const Product_Backend_API = "http://localhost:8083/product";

export const axiosAllProducts = async (id) => {
    id = id || '';
    return await axios.get(Product_Backend_API + '/getAllProducts/' + id);
}

export const axiosAddProduct = async (product) => {
    return await axios.post(Product_Backend_API + '/addProduct', product);
}

export const axiosUpdateProduct = async (id, product) => {
    return await axios.put(Product_Backend_API + '/updateProduct/' + id, product);
}
export const axiosDeleteProduct = async (id) => {
    return await axios.delete(Product_Backend_API + '/deleteProduct/' + id);
}


export const axiosGetById = async (id) => {
    id = id || '';
    return await axios.get(Product_Backend_API + '/getById/' + id);
}
export const axiosGetBycategoryId = async (id) => {
    id = id || '';
    return await axios.get(Product_Backend_API + '/getByCategoryId/' + id);
}
