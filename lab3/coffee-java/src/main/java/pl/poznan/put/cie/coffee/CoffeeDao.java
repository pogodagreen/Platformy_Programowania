package pl.poznan.put.cie.coffee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class CoffeeDao {

	private final NamedParameterJdbcTemplate jdbc;

	public CoffeeDao() {
		// TODO init jdbc using pl.poznan.put.cie.coffee.DbUtilities
		this.jdbc = null;
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * Returns a coffee with given name.
	 *
	 * @param name coffee name
	 * @return coffee object or null
	 */
	public Coffee get(String name) {
		String sql = "SELECT sup_id, price, sales, total FROM coffees "
				  + "WHERE cof_name = :cof_name";
		MapSqlParameterSource params = new MapSqlParameterSource("cof_name", name);
		return jdbc.query(sql, params, new ResultSetExtractor<Coffee>() {

			@Override
			public Coffee extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO implement method #extractData()
				throw new UnsupportedOperationException("Not implemented yet.");
			}
		});
	}

	/**
	 * Returns a list of all coffees.
	 *
	 * @return list of all coffees
	 */
	public List<Coffee> getAll() {
		String sql = "SELECT cof_name, sup_id, price, sales, total FROM coffees";
		try {
			// TODO invoke NamedParameterJdbcTemplate.query(String, RowMapper<T>)
			throw new UnsupportedOperationException("Not implemented yet.");
		} catch (EmptyResultDataAccessException ex) {
			return new ArrayList<>();
		}
	}

	public void update(Coffee c) {
		String sql = "UPDATE coffees "
				  + "SET price = :price, sales = :sales, total = :total "
				  + "WHERE cof_name = :cof_name AND sup_id = :sup_id";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("price", c.getPrice());
		parameters.put("sales", c.getSales());
		parameters.put("total", c.getTotal());
		parameters.put("cof_name", c.getName());
		parameters.put("sup_id", c.getSupplierId());
		jdbc.update(sql, parameters);
	}

	public void delete(String name, int supplierId) {
		// TODO implement method CoffeeDao#delete(), use NamedParameterJdbcTemplate.update(String, Map)
		// DELETE FROM coffees WHERE cof_name = ? AND sup_id = ?
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void create(Coffee c) {
		// TODO implement method CoffeeDao#create(), use NamedParameterJdbcTemplate.update(String, Map)
		// INSERT INTO coffees(cof_name, sup_id, price, sales, total) VALUES(?, ?, ?, ?, ?)
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}
