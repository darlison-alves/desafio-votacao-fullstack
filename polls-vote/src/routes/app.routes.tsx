import { Suspense, lazy } from "react";
import { useRoutes, Navigate } from "react-router-dom";
import { MainLayout } from "../layout/MainLayout";
import Home from "../pages/home";
import Poll from "../pages/poll";

export function AppRoutes() {
  return (
    <Suspense fallback={<div>Loading...</div>}>
      {useRoutes([
        {
          element: <MainLayout />,
          children: [
            { path: "/", element: <Home /> },
            { path: "/polls", element: <Poll /> },
            { path: "/login", element: <div >HE</div> },
          ],
        },
        {
          path: "*",
          element: <div >Not Found</div>,
        },
      ])}
    </Suspense>
  );
}
