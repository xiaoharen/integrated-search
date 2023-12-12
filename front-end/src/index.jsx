import Search from "./component/xhr-search-01/search.jsx";

const App = () => (
    <>
        <Search url={"http://localhost:7529/api/search/all"} />
    </>
);
export default App;