import React, { useEffect, useRef } from 'react'
import { useParams } from 'react-router-dom'

const VueModuleAppListRouter = () => {
    const vueModuleListRef = useRef(null)

    useEffect(() => {
        const loadRemoteComponent = async () => {
            const { listBootstrapMount } = await import('vueModuleApp/boardListBootstrap')
            listBootstrapMount(vueModuleListRef.current)
        }

        loadRemoteComponent()
    }, [vueModuleListRef])

    return (
        <div>
            <div>
                <div style={{ position: 'relative' }} ref={vueModuleListRef} />
            </div>
        </div>
    )
}

export default VueModuleAppListRouter