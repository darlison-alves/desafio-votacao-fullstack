import { Outlet } from "react-router-dom";

export function MainLayout() {
  return (
    <>
      <h1>Sistema Votação</h1>
      <Outlet />
      {/* <footer>Footer</footer> */}
    </>
  );
}
