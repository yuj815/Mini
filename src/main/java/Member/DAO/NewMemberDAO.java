package Member.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Member.DTO.MemberDTO;

public class NewMemberDAO implements MemberDAO{
	
	private JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public MemberDTO getMember(String EMAIL) throws ClassNotFoundException, SQLException {
		List<MemberDTO> results = template.query(
				"SELECT * FROM MEMBER WHERE EMAIL=?",
				new RowMapper<MemberDTO>() {
					@Override
					public MemberDTO mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						MemberDTO member = new MemberDTO( //생성자
								 rs.getString("EMAIL"),
								rs.getString("PWD"),
								 rs.getString("NAME"),
								 rs.getString("CPHONE")
								);
						return member;
					}
				},
				EMAIL);

		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public int insert(MemberDTO member) throws ClassNotFoundException, SQLException {
		
		
		
		return 0;
	}

		
	
	
	
}
