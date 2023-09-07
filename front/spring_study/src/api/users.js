import api from "./api";

export const registerUser = async (user) => {
    return api.post("/user", user);
};

export const updateUser = async (user) => {
    return api.put("/user", user);
};

export const deleteUser = async (user) => {
    return api.delete("/user", user);
};