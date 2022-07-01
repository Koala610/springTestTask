import Student from "./Student";

export default class User{
    id!: Number;
    username!: string;
    password!: string;
    email!: string;
    students!: Array<Student>;
}