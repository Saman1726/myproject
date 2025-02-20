import React from 'react';
import Transactions from './Transactions';
import Categories from './Categories';

const Dashboard = () => {
  return (
    <div >
      <h2>Dashboard</h2>
      <Transactions />
      <Categories />
    </div>
  );
};

export default Dashboard;