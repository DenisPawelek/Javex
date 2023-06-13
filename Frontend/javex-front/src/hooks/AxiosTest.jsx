import { useEffect } from 'react';
import { useAxios } from '../hooks/useAxios';

const AxiosTest = () => {
    // const { response, loading, error } = useAxios({
    //     method: 'POST',
    //     url: '/posts',
    //     headers: { // no need to stringify
    //       accept: '*/*'
    //     },
    //     data: {  // no need to stringify
    //         userId: 1,
    //         id: 19392,
    //         title: 'title',
    //         body: 'Sample text',
    //     },
    // });
    const { response, loading, error } = useAxios({
        method: 'GET',
        url: '/g/many/Product',
        headers: { 
          accept: '*/*'
        },
        data: { 
        },
    });


    useEffect(() => {
        console.log('response', response);
        console.log('loading', loading);
        console.log('error', error);
    }, [response, loading, error]);

    return (
        <div className='AxiosTest'>
            <h1>Posts</h1>

            {loading ? (
                <p>loading...</p>
            ) : (
                <div>
                    {error && (
                        <div>
                            <p>{error.message}</p>
                        </div>
                    )}
                    <div> {
                      // no need to use another state to store data, response is sufficient
                      response && <div> Wartość: {response.map(o => <p key={o.id}>{JSON.stringify(o)}</p>)}</div>
                    }
                    </div>
                </div>
            )}
        </div>
    );
};

export default AxiosTest;