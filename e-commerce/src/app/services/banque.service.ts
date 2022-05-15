import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable()
export class BanqueService {
    private BASE_URL = '/api/operations';

    constructor(private httpclient: HttpClient) {}

    debitercompte(operation: any) {
        this.httpclient
            .post(`/api/operations/debit`, operation)
            .subscribe({
                next: (response) => {
                    console.log(`Echec de effectuée ! `, response);
                },
                error: (error) => {
                    console.error(`Echec de l'opération ! `, error);
                }
            })
    }
}