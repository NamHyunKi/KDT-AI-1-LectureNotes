import React, { useEffect, useRef } from 'react'
import { useParams } from 'react-router-dom'

const VuetifyTypeScriptBoardAppListRouter = () => {
    const vuetifyBoardListRef = useRef(null)

    useEffect(() => {
        const loadRemoteComponent = async () => {
            const { listBootstrapMount } = await import('vuetifyTailwindBoardApp/boardListBootstrap')
            listBootstrapMount(vuetifyBoardListRef.current)
        }

        loadRemoteComponent()
    }, [vuetifyBoardListRef])

    return (
        <div>
            <div>
                <div style={{ position: 'relative' }} ref={vuetifyBoardListRef} />
            </div>
        </div>
    )
}

export default VuetifyTypeScriptBoardAppListRouter