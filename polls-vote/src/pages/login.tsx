import { useState } from "react"
import { useNavigate } from "react-router-dom"
import { PollService } from "../services/poll.service"

function Login() {

    const [loading, setLoading] = useState(false)

    const [document, setDocument] = useState('')

    const navigate = useNavigate()

    function handlePage(path: string) {
        navigate(path, { replace: true })
    }

    function create() {

        setLoading(true)

        localStorage.setItem('document', document)

        navigate('/')
        // PollService.create({
        //     "title": payload.title,
        //     "durationMinutes": payload.durationMinutes
        // }).then(() => {
        //     navigate('/')
        // })
        //     .finally(() => {
        //         setLoading(false)
        //     })
    }

    return (
        <div className="container-form-poll">
            <div className="form-control">
                <label>CPF:</label>
                <input onChange={(evt) => setDocument(evt.target.value)} />
            </div>
            <button disabled={loading} onClick={() => create()}>
                Entrar
            </button>
        </div>
    )
}

export default Login