import "./search.css";
import {useEffect, useState} from "react";

const App = ({url}) => {
    const [searchRequest, setSearchRequest] = useState({
        "searchText": "",
        "type": null
    })
    const [bookItems, setBookItems] = useState([]);
    const [essayItems, setEssayItems] = useState([]);

    const handleSearch = (e) => {
        if (e.key === "Enter") {
            setSearchRequest({
                ...searchRequest,
                searchText: e.target.value
            });
        }
    };

    useEffect(() => {
        if (searchRequest.searchText) {
            fetch(url, {
                method: 'post',
                credentials: 'include',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(searchRequest)
            })
                .then(data => data.json())
                .then(data => {
                    console.log(data.data);
                    setEssayItems(Object.values(data.data.essayList).map(item => (
                        <a key={item.id} href="#">
                            <li>
                                <b>{item.title}</b>
                            </li>
                        </a>
                    )));
                    setBookItems(Object.values(data.data.bookList).map(item => (
                        <a key={item.id} href="#">
                            <li>
                                <b>{item.bookName}</b>
                            </li>
                        </a>
                    )));
                })
                .catch(e => console.log('error:', e));
        }
    }, [searchRequest]);

    return (
        <div className="xhr-search-01">
            <div className="xhr-search-01-header">
                <div className="xhr-search-01-bar">
                    <input
                        id="xhr-search"
                        type="text"
                        placeholder="🔍 Search..."
                        onKeyDown={handleSearch}
                    />
                </div>
            </div>
            <div className="xhr-search-01-container">
                <div className="xhr-search-01-content">
                    <ul>{essayItems}{bookItems}</ul>
                </div>
            </div>
        </div>
    )
};

export default App;