import httpClient from "../http-common"

const getAll = () => {
    return httpClient.get('/cliente/');
}

export default {getAll};