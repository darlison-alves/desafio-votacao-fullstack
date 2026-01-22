import { api } from "./api";

export const PollService = {
    list() {
        return api.get("/polls");
    },

    findById(id: string) {
        return api.get(`/polls/${id}`);
    },

    create(payload: any) {
        return api.post("/polls", payload);
    },

    vote(payload: any) {
        return api.post("/polls/vote", payload);
    }
};