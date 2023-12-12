import { HashRouter, Routes, Route } from "react-router-dom";
import Index from "../index";

function route() {
    return (
        <HashRouter>
            <Routes>
                <Route path="/" element={<Index />}></Route>
            </Routes>
        </HashRouter>
    );
}

export default route;