import React, { useEffect, useState } from 'react';
import { getTransactions, addTransaction, getCategorieByName} from '../../api';

const Transactions = () => {
  const [transactions, setTransactions] = useState([]);
  const [amount, setAmount] = useState('');
  const [category, setCategory] = useState('');
  const [date, setDate] = useState('');
  const [description, setDescription] = useState('');

  useEffect(() => {
    const fetchTransactions = async () => {
      const token = localStorage.getItem('token');
      const response = await getTransactions(token);
      setTransactions(response.data);
    };

    fetchTransactions();
  }, []);

  const handleAddTransaction = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');
    const categoryID = await getCategorieByName(token,category);
    const newTransaction = { amount, categoryID, date, description };
    await addTransaction(newTransaction, token);
    setTransactions([...transactions, newTransaction]);
  };

  return (
    <div>
      <h3>Transactions</h3>
      <form onSubmit={handleAddTransaction}>
        <div>
          <label>Amount:</label>
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
        </div>
        <div>
          <label>Category:</label>
          <input
            type="text"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
          />
        </div>
        <div>
          <label>Date:</label>
          <input
            type="date"
            value={date}
            onChange={(e) => setDate(e.target.value)}
          />
        </div>
        <div>
          <label>Description:</label>
          <input
            type="text"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
        </div>
        <button type="submit">Add Transaction</button>
      </form>
      <ul>
        {transactions.map((transaction) => (
          <li key={transaction.id}>
            {transaction.amount} - {transaction.category} - {transaction.date} - {transaction.description}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Transactions;