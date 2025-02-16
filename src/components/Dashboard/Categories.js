import React, { useEffect, useState } from 'react';
import { getCategories, addCategory } from '../../api';

const Categories = () => {
  const [categories, setCategories] = useState([]);
  const [name, setName] = useState('');

  useEffect(() => {
    const fetchCategories = async () => {
      const token = localStorage.getItem('token');
      const response = await getCategories(token);
      setCategories(response.data);
    };

    fetchCategories();
  }, []);

  const handleAddCategory = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');
    const newCategory = { name };
    await addCategory(newCategory, token);
    setCategories([...categories, newCategory]);
  };

  return (
    <div>
      <h3>Categories</h3>
      <form onSubmit={handleAddCategory}>
        <div>
          <label>Name:</label>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <button type="submit">Add Category</button>
      </form>
      <ul>
        {categories.map((category) => (
          <li key={category.id}>{category.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Categories;